package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;


public enum AccessModifierChangesMutator implements MethodMutatorFactory {

    ACCESS_MODIFIER_CHANGES;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
        return new ClassMethodVisitor(this, methodInfo, context, methodVisitor);
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

/**
 * Changes access modifiers (private, public, protected)
 */
class ClassMethodVisitor extends AbstractInsnMutator {
    
    ClassMethodVisitor(final MethodMutatorFactory factory,
        final MethodInfo methodInfo, final MutationContext context,
        final MethodVisitor writer) {
        super(factory, methodInfo, context, writer);
    }
    
    private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

    static {
        MUTATIONS.put(Opcodes.ACC_PRIVATE, new InsnSubstitution(Opcodes.ACC_PUBLIC, "Replaced private access with public access"));
        MUTATIONS.put(Opcodes.ACC_PRIVATE, new InsnSubstitution(Opcodes.ACC_PROTECTED, "Replaced private access with protected access"));
        MUTATIONS.put(Opcodes.ACC_PROTECTED, new InsnSubstitution(Opcodes.ACC_PUBLIC, "Replaced protected access with public access"));
        MUTATIONS.put(Opcodes.ACC_PROTECTED, new InsnSubstitution(Opcodes.ACC_PRIVATE, "Replaced protected access with private access"));
        MUTATIONS.put(Opcodes.ACC_PUBLIC, new InsnSubstitution(Opcodes.ACC_PRIVATE, "Replaced public access with private access"));
        MUTATIONS.put(Opcodes.ACC_PUBLIC, new InsnSubstitution(Opcodes.ACC_PROTECTED, "Replaced public access with protected access"));
    }
    
    @Override
    protected Map<Integer, ZeroOperandMutation> getMutations() {
        return MUTATIONS;
    }
}
