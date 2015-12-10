package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class StaticFieldMutator implements MethodMutatorFactory {

    private final class StaticFieldVisitor extends MethodVisitor {

        private final MutationContext context;

        public StaticFieldVisitor(final MutationContext context,
                                     final MethodVisitor delegateVisitor) {
            super(Opcodes.ASM5, delegateVisitor);
            this.context = context;
        }

        @Override
        public void visitFieldInsn(final int opcode, final String owner,
                                   final String name, final String desc) {
            if ((Opcodes.PUTSTATIC == opcode) && shouldMutate(name)) {
                // removed setting field

                super.visitInsn(Opcodes.PUTFIELD);
            } else if ((Opcodes.PUTFIELD == opcode) && shouldMutate(name)) {
                // removed setting field

                super.visitInsn(Opcodes.PUTSTATIC);
            } else {
                super.visitFieldInsn(opcode, owner, name, desc);
            }
        }

        /*
         * (non-Javadoc)
         *
         * @see org.objectweb.asm.MethodAdapter#visitMethodInsn(int,
         * java.lang.String, java.lang.String, java.lang.String)
         */
        @Override
        public void visitMethodInsn(final int opcode, final String owner,
                                    final String name, final String desc, boolean itf) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }

        private boolean shouldMutate(final String fieldName) {
            final MutationIdentifier mutationId = this.context.registerMutation(
                    StaticFieldMutator.this, "Removed static to member variable "
                            + fieldName);
            return this.context.shouldMutate(mutationId);
        }

    }

    @Override
    public MethodVisitor create(final MutationContext context,
                                final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
        return new StaticFieldVisitor(context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
        return this.getClass().getName();
    }

    @Override
    public String toString() {
        return "STATIC_MODIFIER_CHANGES_MUTATOR";
    }

    @Override
    public String getName() {
        return toString();
    }

}