package org.jannocessor.data;

import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.executable.JavaExecutable;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.Text;



public class JavaExecutableData extends JavaElementData implements JavaExecutable {

    //private List<JavaTypeParameter> _${m.name.getClone().deleteParts(0)};

    //private JavaElementType _${m.name.getClone().deleteParts(0)};

    //private List<JavaParameter> _${m.name.getClone().deleteParts(0)};

    //private Boolean _${m.name.getClone().deleteParts(0)};

    //private List<JavaElementType> _${m.name.getClone().deleteParts(0)};

    //private Text _${m.name.getClone().deleteParts(0)};


    public List<JavaTypeParameter> getTypeParameters() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setTypeParameters(List<JavaTypeParameter> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public JavaElementType getReturnType() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setReturnType(JavaElementType value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaParameter> getParameters() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setParameters(List<JavaParameter> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Boolean getVarArgs() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setVarArgs(Boolean value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaElementType> getThrownTypes() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setThrownTypes(List<JavaElementType> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Text getDefault() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setDefault(Text value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


