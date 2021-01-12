package com.udemy.projetospring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.udemy.projetospring.entities.enums.PedidoStatus;

@Entity
@Table(name = "tb_order")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momento;

    private Integer pedidoStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Usuario client;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoItem> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Long id, Instant momento, PedidoStatus pedidoStatus, Usuario client) {
        this.id = id;
        this.momento = momento;
        setPedidoStatus(pedidoStatus);
        this.client = client;
    }

    public PedidoStatus getPedidoStatus() {
        return PedidoStatus.valueOf(pedidoStatus);
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus.getCodigo();
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return client;
    }

    public void setUsuario(Usuario usuario) {
        this.client = usuario;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(momento, pedido.momento)
                && Objects.equals(client, pedido.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, momento, client);
    }

}
