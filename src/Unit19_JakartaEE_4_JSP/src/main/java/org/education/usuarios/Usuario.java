package org.education.usuarios;

public class Usuario {

  private String nombre;
  private String apellido;
  private String usuario;
  private String pais;
  private int salario;

  public Usuario(String nombre, String apellido, String usuario, String pais, int salario) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.usuario = usuario;
    this.pais = pais;
    this.salario = salario;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public int getSalario() {
    return salario;
  }

  public void setSalario(int salario) {
    this.salario = salario;
  }
}
