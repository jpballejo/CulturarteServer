/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author nicolasgutierrez
 */
public interface iConUsuario {
    
    public abstract void cargarUsuarios();
    public abstract void agregarUsu(dtUsuario usuario);
    public abstract List<dtProponente> listarProponentes();
    public abstract dtUsuario infoProponente(String idProponente);
    public abstract List<dtColaborador> listarColaboradores();
    public abstract dtColaborador infoColaborador(String idColaborador);
    public abstract List<dtPropuesta> listarPropuestas(String idColaborador);
    public abstract List<dtColaborador> listarColaboradores(String idPropuesta);
    public abstract dtColaboraciones seleccionarColaborador(String idColaborador);
    public abstract void seguir(String nicknameSeguidor, String nicknameASeguir);
    public abstract void dejarDeSeguir(String nicknameSeguidor, String nicknameADejarDeSeguir);
    
}
