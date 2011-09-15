package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaExecutableData;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaMethodData extends JavaExecutableData implements JavaMethod {

    private PowerList<JavaTypeParameter> typeParameters;

    private JavaElementType returnType;

    private PowerList<JavaParameter> parameters;

    private Boolean varArgs;

    private PowerList<JavaElementType> thrownTypes;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this.typeParameters = value;
    }

    public JavaElementType getReturnType() {
        return this.returnType;
    }

    public void setReturnType(JavaElementType value) {
        this.returnType = value;
    }

    public PowerList<JavaParameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaParameter> value) {
        this.parameters = value;
    }

    public Boolean getVarArgs() {
        return this.varArgs;
    }

    public void setVarArgs(Boolean value) {
        this.varArgs = value;
    }

    public PowerList<JavaElementType> getThrownTypes() {
        return this.thrownTypes;
    }

    public void setThrownTypes(PowerList<JavaElementType> value) {
        this.thrownTypes = value;
    }


}


