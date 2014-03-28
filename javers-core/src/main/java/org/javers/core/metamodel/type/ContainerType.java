package org.javers.core.metamodel.type;

import org.javers.common.exception.exceptions.JaversException;

import java.lang.reflect.Type;
import java.util.List;

import static org.javers.common.exception.exceptions.JaversExceptionCode.GENERIC_TYPE_NOT_PARAMETRIZED;

/**
 * Collection or Array
 *
 * @author bartosz walacik
 */
public abstract class ContainerType extends EnumerableType {

    ContainerType(Type baseJavaType) {
        super(baseJavaType);
    }

    /**
     * never returns null
     * @throws org.javers.common.exception.exceptions.JaversException GENERIC_TYPE_NOT_PARAMETRIZED
     */
    public Class getItemClass(){
        if (isFullyParameterized()) {
            return getElementTypes().get(0);
        }
        throw new JaversException(GENERIC_TYPE_NOT_PARAMETRIZED, getBaseJavaType().toString());
    }
}
