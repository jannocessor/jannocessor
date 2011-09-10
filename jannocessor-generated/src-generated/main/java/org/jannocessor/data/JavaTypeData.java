package org.jannocessor.data;

import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.Text;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;



public class JavaTypeData extends JavaElementData implements JavaType {

    private Text _getNesting;

    private Name _getPackageName;

    private Name _getQualifiedName;

    private JavaElementType _getSuperclass;

    private List<JavaElementType> _getInterfaces;

    private List<JavaTypeParameter> _getParameters;


    public Text getNesting() {
        return this._getNesting;
    }

    public void setNesting(Text value) {
        this._getNesting = value;
    }

    public Name getPackageName() {
        return this._getPackageName;
    }

    public void setPackageName(Name value) {
        this._getPackageName = value;
    }

    public Name getQualifiedName() {
        return this._getQualifiedName;
    }

    public void setQualifiedName(Name value) {
        this._getQualifiedName = value;
    }

    public JavaElementType getSuperclass() {
        return this._getSuperclass;
    }

    public void setSuperclass(JavaElementType value) {
        this._getSuperclass = value;
    }

    public List<JavaElementType> getInterfaces() {
        return this._getInterfaces;
    }

    public void setInterfaces(List<JavaElementType> value) {
        this._getInterfaces = value;
    }

    public List<JavaTypeParameter> getParameters() {
        return this._getParameters;
    }

    public void setParameters(List<JavaTypeParameter> value) {
        this._getParameters = value;
    }


}


