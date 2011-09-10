package org.jannocessor.data;

import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.executable.JavaExecutable;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.Text;



public class JavaExecutableData extends JavaElementData implements JavaExecutable {

    private List<JavaTypeParameter> _getTypeParameters;

    private JavaElementType _getReturnType;

    private List<JavaParameter> _getParameters;

    private Boolean _getVarArgs;

    private List<JavaElementType> _getThrownTypes;

    private Text _getDefault;


    public List<JavaTypeParameter> getTypeParameters() {
        return this._getTypeParameters;
    }

    public void setTypeParameters(List<JavaTypeParameter> value) {
        this._getTypeParameters = value;
    }

    public JavaElementType getReturnType() {
        return this._getReturnType;
    }

    public void setReturnType(JavaElementType value) {
        this._getReturnType = value;
    }

    public List<JavaParameter> getParameters() {
        return this._getParameters;
    }

    public void setParameters(List<JavaParameter> value) {
        this._getParameters = value;
    }

    public Boolean getVarArgs() {
        return this._getVarArgs;
    }

    public void setVarArgs(Boolean value) {
        this._getVarArgs = value;
    }

    public List<JavaElementType> getThrownTypes() {
        return this._getThrownTypes;
    }

    public void setThrownTypes(List<JavaElementType> value) {
        this._getThrownTypes = value;
    }

    public Text getDefault() {
        return this._getDefault;
    }

    public void setDefault(Text value) {
        this._getDefault = value;
    }


}


