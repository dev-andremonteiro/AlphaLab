/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.entity.software;

/**
 *
 * @author tcloss
 */
public enum TipoSoftwareEnum {
 
    COMPILADOR("Compilador"),
    IDE("IDE"),
    EDITOR_TEXTO("Editor de texto"),
    EDITOR_IMAGEM("Editor de imagem");
    
    private final String descricao;

    private TipoSoftwareEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
    
}
