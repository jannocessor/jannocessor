package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeData extends JavaElementData implements JavaType {

    private String nesting;

    private Name packageName;

    private Name qualifiedName;

    private JavaElementType superclass;

    private PowerList<JavaElementType> interfaces;

    private PowerList<JavaTypeParameter> parameters;


    public String getNesting() {
        return this.nesting;
    }

    public void setNesting(String value) {
        this.nesting = value;
    }

    public Name getPackageName() {
        return this.packageName;
    }

    public void setPackageName(Name value) {
        this.packageName = value;
    }

    public Name getQualifiedName() {
        return this.qualifiedName;
    }

    public void setQualifiedName(Name value) {
        this.qualifiedName = value;
    }

    public JavaElementType getSuperclass() {
        return this.superclass;
    }

    public void setSuperclass(JavaElementType value) {
        this.superclass = value;
    }

    public PowerList<JavaElementType> getInterfaces() {
        return this.interfaces;
    }

    public void setInterfaces(PowerList<JavaElementType> value) {
        this.interfaces = value;
    }

    public PowerList<JavaTypeParameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaTypeParameter> value) {
        this.parameters = value;
    }


}


