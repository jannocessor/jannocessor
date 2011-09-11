package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.Text;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeData extends JavaElementData implements JavaType {

    private Text _getNesting;

    private Name _getPackageName;

    private Name _getQualifiedName;

    private JavaElementType _getSuperclass;

    private PowerList<JavaElementType> _getInterfaces;

    private PowerList<JavaTypeParameter> _getParameters;


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

    public PowerList<JavaElementType> getInterfaces() {
        return this._getInterfaces;
    }

    public void setInterfaces(PowerList<JavaElementType> value) {
        this._getInterfaces = value;
    }

    public PowerList<JavaTypeParameter> getParameters() {
        return this._getParameters;
    }

    public void setParameters(PowerList<JavaTypeParameter> value) {
        this._getParameters = value;
    }


}


