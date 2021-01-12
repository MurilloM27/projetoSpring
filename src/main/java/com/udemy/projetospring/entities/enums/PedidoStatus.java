package com.udemy.projetospring.entities.enums;

public enum PedidoStatus {
    
    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int codigo;

    private PedidoStatus(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public static PedidoStatus valueOf(int codigo){
        for (PedidoStatus valorPedido : PedidoStatus.values()) {
            if(valorPedido.getCodigo() == codigo){
                return valorPedido;
            }
        }
        throw new IllegalArgumentException("Status de Pedido Inválido!");
    }
}
