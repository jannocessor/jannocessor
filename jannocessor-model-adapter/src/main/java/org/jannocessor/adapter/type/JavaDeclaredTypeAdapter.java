package org.jannocessor.adapter.type;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;

public class JavaDeclaredTypeAdapter extends JavaTypeAdapter implements JavaDeclaredType {

    public JavaDeclaredTypeAdapter(DeclaredType declaredType, Elements elementUtils, Types typeUtils) {
        super(declaredType, elementUtils, typeUtils);
		this.setCode(Code.code(JavaDeclaredType.class));
        // TODO Auto-generated constructor stub
    }

    @Override
    public PowerList<JavaType> getParameters() {
        PowerList<JavaType> arguments = Power.list();

        DeclaredType declaredType = getDeclaredType();
        if (declaredType != null) {
            for (TypeMirror typeArg : declaredType.getTypeArguments()) {
                arguments.add(getTypeAdapter(typeArg));
            }
        }

        return arguments;
    }

}
