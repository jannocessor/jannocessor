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

    private PowerList<JavaTypeParameter> _getTypeParameters;

    private PowerList<JavaParameter> _getParameters;

    private Boolean _getVarArgs;

    private PowerList<JavaElementType> _getThrownTypes;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this._getTypeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this._getTypeParameters = value;
    }

    public PowerList<JavaParameter> getParameters() {
        return this._getParameters;
    }

    public void setParameters(PowerList<JavaParameter> value) {
        this._getParameters = value;
    }

    public Boolean getVarArgs() {
        return this._getVarArgs;
    }

    public void setVarArgs(Boolean value) {
        this._getVarArgs = value;
    }

    public PowerList<JavaElementType> getThrownTypes() {
        return this._getThrownTypes;
    }

    public void setThrownTypes(PowerList<JavaElementType> value) {
        this._getThrownTypes = value;
    }


}


