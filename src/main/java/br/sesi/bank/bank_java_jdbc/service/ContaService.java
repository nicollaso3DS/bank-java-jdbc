package br.sesi.bank.bank_java_jdbc.service;

import br.sesi.bank.bank_java_jdbc.domain.cliente.Cliente;
import br.sesi.bank.bank_java_jdbc.domain.conta.Conta;
import br.sesi.bank.bank_java_jdbc.domain.conta.DadosAberturaConta;
import br.sesi.bank.bank_java_jdbc.exceptions.RegraDeNegocioException;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ContaService {
    private Set<Conta> contas = new HashSet<Conta>();
    public ContaService(){ }
    public Set<Conta> listarContasAbertas() {return null;}
    public BigDecimal consultarSaldo(Integer numeroDaConta) { return BigDecimal.ZERO;}
    public void abrir(DadosAberturaConta dadosDaConta) throws SQLException {
        Cliente cliente  = new Cliente(dadosDaConta.dadosCliente);
        Conta conta = new Conta(dadosDaConta.numero, BigDecimal.ZERO, cliente);
        if (contas.contains(conta)) {
            throw new RegraDeNegocioException("Já existe outra conta aberta com o mesmo numero!");
            }
        contas.add(conta);
    }
    public void realizarSaque(Integer numeroDaConta, BigDecimal valor) {
        Conta conta = buscarContaPorNumero(numeroDaConta);
        if (valor.compareTo(BigDecimal.ZERO) <=0) {
            throw new RegraDeNegocioException("Valor do saque deve ser superior a zero!");
        }
        if (valor.compareTo(conta.getSaldo()) >0) {
            throw new RegraDeNegocioException("Saldo insuficienite!");
        }
        conta.sacar(valor);
    }
    public void realizarDeposito(Integer numeroDaConta, BigDecimal valor) { }
    public void realizaTransferencia(Integer numeroContaOrigem, Integer numeroContaDestino, BigDecimal valor){ }
    public void encerrar(Integer numeroDaConta) { }
    private Conta buscarContaPorNumero(Integer numero) { return null;}
    private void alterar(Integer numeroDaConta, BigDecimal valor) { }


    
}


