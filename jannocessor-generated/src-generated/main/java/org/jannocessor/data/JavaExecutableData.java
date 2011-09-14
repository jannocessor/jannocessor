package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.executable.JavaExecutable;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableData extends JavaElementData implements JavaExecutable {

    private PowerList<JavaTypeParameter> _getTypeParameters;

    private JavaElementType _getReturnType;

    private PowerList<JavaParameter> _getParameters;

    private Boolean _getVarArgs;

    private PowerList<JavaElementType> _getThrownTypes;

    private String _getDefault;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this._getTypeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this._getTypeParameters = value;
    }

    public JavaElementType getReturnType() {
        return this._getReturnType;
    }

    public void setReturnType(JavaElementType value) {
        this._getReturnType = value;
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

    public String getDefault() {
        return this._getDefault;
    }

    public void setDefault(String value) {
        this._getDefault = value;
    }


}


