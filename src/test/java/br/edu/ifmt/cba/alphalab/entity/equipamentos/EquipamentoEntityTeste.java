package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntityTeste;

public class EquipamentoEntityTeste {
    
     EquipamentoEntity equipamento;
    

    
    @BeforeClass
    public void setUp() {
        equipamento= new EquipamentoEntity(2L,"Teste");
       
       
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void TestarValidarEquipamento(){
        assertNull(equipamento.validar());
    }

}
