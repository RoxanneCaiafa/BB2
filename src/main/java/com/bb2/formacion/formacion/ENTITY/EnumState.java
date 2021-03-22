package com.bb2.formacion.formacion.ENTITY;

public enum EnumState {
    DISCONTINUED("DISCONTINUED"), ACTIVE("ACTIVE");
    private String description;

    private EnumState(String descripcion){
        this.description = descripcion;
    }

    public String getDescription() {
        return description;
    }

    public static EnumState getByName(String name){
        return   EnumState.valueOf(name);
    }
}
