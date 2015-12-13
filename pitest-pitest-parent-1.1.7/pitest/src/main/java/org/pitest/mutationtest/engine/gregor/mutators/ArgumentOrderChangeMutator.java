package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public enum ArgumentOrderChangeMutator implements MethodMutatorFactory {

    ARGUMENT_ORDER_CHANGE_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
                                final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
        return new ArgumentOrderChangeVisitor(context, methodVisitor, this);
    }

    @Override
    public String getGloballyUniqueId() {
        return this.getClass().getName();
    }

    @Override
    public String getName() {
        return name();
    }
}

class ArgumentOrderChangeVisitor extends MethodVisitor {

    private final MethodMutatorFactory factory;
    private final MutationContext      context;

    public ArgumentOrderChangeVisitor(final MutationContext context,
                                   final MethodVisitor writer, final MethodMutatorFactory factory) {
        super(Opcodes.ASM5, writer);
        this.factory = factory;
        this.context = context;
    }

    @Override
    public void visitMethodInsn(final int opcode, final String owner,
                                final String name, final String desc, final boolean itf) {

        if (hasEnoughArguments(desc)) {
            final MutationIdentifier newId = this.context.registerMutation(
                    this.factory, "swap the 2 last arguments in " + owner + "::" + name);

            /*System.out.println("################################################################################");
            System.out.println("opcode: " + opcode);
            System.out.println("owner: " + owner);
            System.out.println("name: " + name);
            System.out.println("desc: " + desc);
            System.out.println("itf: " + itf);
            System.out.println("arg number: " + Type.getArgumentTypes(desc).length);
            System.out.println("hasEnoughArguments: " + hasEnoughArguments(desc));
            System.out.println("shouldMutate: " + this.context.shouldMutate(newId));*/

            Type[] arguments = Type.getArgumentTypes(desc);
            int i = arguments.length - 1;
            int j = i - 1;

            Type stackTop = arguments[i];
            Type belowTop = arguments[j];

            System.out.println(stackTop);
            System.out.println(stackTop.getSize());
            System.out.println(belowTop);
            System.out.println(belowTop.getSize());

            swap(this.mv, stackTop, belowTop);

            arguments[i] = belowTop;
            arguments[j] = stackTop;

            Type[] newArguments = new Type[i + 1];
            for (int k = 0; k < i; k++) {
                newArguments[k] = arguments[k];
            }
            newArguments[j] = stackTop;
            newArguments[i] = belowTop;

            //System.out.println(Type.getMethodDescriptor(Type.getReturnType(desc), newArguments));

            String newDesc = Type.getMethodDescriptor(Type.getReturnType(desc), newArguments);

            this.mv.visitMethodInsn(opcode, owner, name, newDesc, itf);
        } else {
            this.mv.visitMethodInsn(opcode, owner, name, desc, itf);
        }
    }

    private boolean hasEnoughArguments(String desc) {
        return Type.getArgumentTypes(desc).length > 1 ? true : false;
    }

    private static void swap(final MethodVisitor mv, final Type stackTop,
                             final Type belowTop) {
        if (stackTop.getSize() == 1) {
            if (belowTop.getSize() == 1) {
                // Top = 1, below = 1
                mv.visitInsn(Opcodes.SWAP);
            } else {
                // Top = 1, below = 2
                mv.visitInsn(Opcodes.DUP_X2);
                mv.visitInsn(Opcodes.POP);
            }
        } else {
            if (belowTop.getSize() == 1) {
                // Top = 2, below = 1
                mv.visitInsn(Opcodes.DUP2_X1);
            } else {
                // Top = 2, below = 2
                mv.visitInsn(Opcodes.DUP2_X2);
            }
            mv.visitInsn(Opcodes.POP2);
        }
    }

}