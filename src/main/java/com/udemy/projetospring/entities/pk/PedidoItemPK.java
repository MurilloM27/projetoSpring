package com.udemy.projetospring.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.udemy.projetospring.entities.Pedido;
import com.udemy.projetospring.entities.Produto;

@Embeddable
public class PedidoItemPK implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PedidoItemPK)) {
            return false;
        }
        PedidoItemPK pedidoItemPK = (PedidoItemPK) o;
        return Objects.equals(pedido, pedidoItemPK.pedido) && Objects.equals(produto, pedidoItemPK.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }

}
