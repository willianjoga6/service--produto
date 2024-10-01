package model;

import javax.persistence.*;

@Entity
@Table(name = "tb_produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;
    private double preco;
}
