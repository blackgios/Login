/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.zazil.security;

/**
 *
 * @author Hector Rodriguez
 */
public class Principal implements java.security.Principal{
    
    String name;
    
    public Principal(String name){
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object  o){
        try{
            return this.name.equals(((Principal)o).getName());
        }finally{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "[Principal: " +this.name + "]";
    }

    @Override
    public int hashCode() {
        return (name == null ? 0 : name.hashCode());
    }
}
