package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class ReservaEntityTest {
    
    static ReservaEntity reserva;
    static DepartamentoEntity departamentoReserva;
    static ServidorEntity solicitanteReserva;
    static ServidorEntity aprovadorReserva;
    static ArrayList<RequisitoEntity> requisitoReserva;

    @BeforeClass
    public static void initialize(){
        reserva = new ReservaEntity();
        departamentoReserva = new DepartamentoEntity();
        solicitanteReserva = new ServidorEntity();
        aprovadorReserva = new ServidorEntity();
        requisitoReserva = new ArrayList<RequisitoEntity>();
    }
    
    @Before
    public void setUp() {
        
        reserva.setId(Long.MIN_VALUE);
        reserva.setStatus(EnumReserva.Pedido);
        reserva.setDataSolicitacao(new java.util.Date());
        reserva.setDisciplina("Eng Software");
        reserva.setTurma("Eng da Computa��o");
        reserva.setObservacao("Aula 15");
        reserva.setFixo(false);
        reserva.setDataInicio(new java.util.Date());
        reserva.setDataFim(new java.util.Date());
        reserva.setDataAprovacaoRecusa(new java.util.Date());
        reserva.setJustificativa("justificando...");
        reserva.setDepartamentoAula(departamentoReserva);
        reserva.setSolicitante(solicitanteReserva);
        reserva.setAprovador(aprovadorReserva);
        reserva.setRequisitos(requisitoReserva);
        
    }

    @Ignore
    @Test
    public void verificarCamposObrigatorios() {
        reserva.setId(null);
	assertNotNull(reserva.validar());
        
        reserva.setStatus(null);
	assertNotNull(reserva.validar());
		
	reserva.setDataSolicitacao(null);
	assertNotNull(reserva.validar());
        
        reserva.setDisciplina(null);
        assertNotNull(reserva.validar());
        
        reserva.setDisciplina("    ");
        assertNotNull(reserva.validar());
        
        reserva.setTurma(null);
        assertNotNull(reserva.validar());
        
        reserva.setTurma("    ");
        assertNotNull(reserva.validar());
        
        reserva.setDataInicio(null);
        assertNotNull(reserva.validar());
        
        reserva.setDataFim(null);
        assertNotNull(reserva.validar());
        
        reserva.setDepartamentoAula(null);
        assertNotNull(reserva.validar());
        
        reserva.setSolicitante(null);
        assertNotNull(reserva.validar());
    }
    
    
    
    
    @AfterClass
    public static void finallize() {
        
        reserva = null;
        departamentoReserva = null;
        solicitanteReserva = null;
        aprovadorReserva = null;
        requisitoReserva = null;
        
    }
}
