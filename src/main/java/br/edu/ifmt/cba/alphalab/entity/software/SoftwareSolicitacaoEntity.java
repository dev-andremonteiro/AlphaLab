/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

/**
 *
 * @author tcloss
 */
public class SoftwareSolicitacaoEntity extends SoftwareEntity {
    private boolean instalado;

    public SoftwareSolicitacaoEntity(String descricao, Enum tipo, String versao, String link, String observacao_Instalacao, Enum status, ServidorEntity solicitante) {
        super(descricao, tipo, versao, link, observacao_Instalacao, status, solicitante);
    }
    
    public boolean isInstalado() {
        return instalado;
    }

    public void setInstalado(boolean instalado) {
        this.instalado = instalado;
    }
    
    
}
