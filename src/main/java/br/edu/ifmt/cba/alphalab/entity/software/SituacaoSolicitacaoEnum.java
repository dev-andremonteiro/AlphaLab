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
public enum SituacaoSolicitacaoEnum {
    CONCLUIDO("Concluído"),
    EM_ANDAMENTO("Em andamento"),
    AGUARDANDO_ATRIBUICAO("Aguardando atribuição"),
    ATRIBUIDO("Atribuído");

    private String descricao;
    private SituacaoSolicitacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
    
    
}
