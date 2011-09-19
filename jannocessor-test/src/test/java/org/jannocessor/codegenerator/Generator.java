package org.jannocessor.codegenerator;

import static org.jannocessor.model.modifier.NestedClassModifierValue.*;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.jannocessor.model.modifier.NestedClassModifierValue;

@SuppressWarnings("rawtypes")
public class Generator {

    // public static final MethodModifierValue[][] GROUPS = { { PUBLIC,
    // PROTECTED, PRIVATE }, { FINAL, ABSTRACT },
    // { ABSTRACT, PRIVATE }, { NATIVE, STRICTFP }, { ABSTRACT, SYNCHRONIZED },
    // { ABSTRACT, STATIC },
    // { ABSTRACT, NATIVE }, { ABSTRACT, STRICTFP } };

    // public static final FieldModifierValue[][] GROUPS = { { PUBLIC,
    // PROTECTED, PRIVATE }, { FINAL, VOLATILE } };

    public static final NestedClassModifierValue[][] GROUPS = { { PUBLIC, PROTECTED, PRIVATE }, { FINAL, ABSTRACT } };

    private static int n = 0;

    public static void main(String[] args) {
        gen3(NestedClassModifierValue.values());
    }

    private static void gen3(Enum[] values) {
        for (Enum a : values) {
            process(a);
            for (Enum b : values) {
                process(a, b);
                for (Enum c : values) {
                    process(a, b, c);
                    for (Enum d : values) {
                        process(a, b, c, d);
                        for (Enum e : values) {
                            process(a, b, c, d, e);
                            for (Enum f : values) {
                                process(a, b, c, d, e, f);
                                for (Enum g : values) {
                                    process(a, b, c, d, e, f, g);
                                    for (Enum h : values) {
                                        process(a, b, c, d, e, f, g, h);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void print(Enum... values) {
        String ss = "NestedClassModifierValue";
        String doc = StringUtils.join(values, " ").toLowerCase();
        String str = "public static final NestedClassModifiers " + StringUtils.join(values, "_")
                + " = Code.nestedClassModifiers(" + ss + "." + StringUtils.join(values, ", " + ss + ".") + ");";

        System.out.println("/** Represents \"" + doc + "\" nested class modifiers. */\n" + str + "\n");
    }

    @SuppressWarnings("unused")
    private static void print2(Enum... values) {
        String str = StringUtils.join(values, " ").toLowerCase() + " class Cls" + n++ + " {}";
        System.out.println(str);
    }

    private static void process(Enum... objs) {
        if (fit(objs)) {
            print(objs);
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean fit(Enum... objs) {
        for (int i = 1; i < objs.length; i++) {
            if (!(objs[i - 1].compareTo(objs[i]) < 0)) {
                return false;
            }
        }
        return notGroup(objs);
    }

    private static boolean notGroup(Enum[] values) {
        for (Enum[] group : GROUPS) {
            boolean found = false;
            for (Enum enum1 : values) {
                if (ArrayUtils.contains(group, enum1)) {
                    if (!found) {
                        found = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
