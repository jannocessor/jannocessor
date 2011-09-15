package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaExecutableData;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.JavaElementType;


@Generated("JAnnocessor-bootstraped")
public class JavaConstructorData extends JavaExecutableData implements JavaConstructor {

    private PowerList<JavaTypeParameter> typeParameters;

    private PowerList<JavaParameter> parameters;

    private Boolean varArgs;

    private PowerList<JavaElementType> thrownTypes;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this.typeParameters = value;
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


