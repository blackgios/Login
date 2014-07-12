/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 *
 * @author Hector Rodriguez
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
public @interface Baja {
    boolean activo() default (true);
}
