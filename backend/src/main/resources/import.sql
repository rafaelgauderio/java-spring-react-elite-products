INSERT INTO tb_embalagem(descricao , data_insercao) VALUES ('fardo com 8 rolos', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('fardo com 4 rolos' , now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('2.400 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('2.000 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('4.000 metros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('caixa com 2.700 folhas', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('galão de 2 litros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('galão de 5 litros', now());
INSERT INTO tb_embalagem(descricao, data_insercao) VALUES ('bombona de 20 litros', now());


INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('papel toalha', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('papel higiênico', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('guardanapo', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('interfolhado', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('rolo', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('excellence', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('plus', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('classic', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha simples', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha dupla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha tripla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('folha quádrupla', now());
INSERT INTO tb_categoria(descricao, data_insercao) VALUES ('Amaciante', now());

INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7127','Papel higiênico em rolo 100% fibras virgens, Folha Dupla, Super Macio, Folhas Brancas',10.0, 300, 'https://melhoramentoshigieners.com.br/imagens/7127.png', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Higiênico Rolo 7111','Papel higiênico em rolo 100% fibras virgens, Folha Simples, Super Macio, Folhas Brancas',10.0, 500, 'https://melhoramentoshigieners.com.br/imagens/7111.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');
INSERT INTO tb_produto(descricao, descricao_completa, largura, metragem, img_url, data_cadastro) VALUES ('Papel Toalha Interfolhado 7234','Papel Toalha interfolhado 100% fibras virgens, Folha Quádrupla, Super Macio, Folhas Brancas, Tamanho da folha: 21 x 21 cm, Folhas por pacote: 150, Pacotes por caixa: 18',21.0, 2700, 'https://melhoramentoshigieners.com.br/imagens/7234.jpg', TIMESTAMP WITH TIME ZONE '2023-03-01T16:00:00.12345Z');

INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (1,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (1,3);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (2,1);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (2,5);
INSERT INTO tb_produto_embalagem (produto_id, embalagem_id) VALUES (3,6);



INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1,10);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,7);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2,9);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3,12);



INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Rafael' , 'De Luca','rafaeldeluca@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Maria' , 'da Silva','mariadasilva@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Juliana' , 'de Luca','julianadeluca@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_usuario(nome, sobrenome, email, password) VALUES ('Claudia' , 'Moreira','claudiamoreira@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem todas as permissoes de CRUD. Acesso a todas as rotas.','ROLE_ADMIN_SISTEMA');
INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem permissao de CRUD em algumas entidades. Não tem permissao de CRUD de usuarios e regras de acesso.','ROLE_GERENTE_LOJA');
INSERT INTO tb_regra (descricao, permissao) VALUES ('Tem permissao de GET em todos as rotas','ROLE_CLIENTE');

INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (1,1);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (1,2);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (2,2);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (3,2);
INSERT INTO tb_usuario_regra (usuario_id, regra_id) VALUES (4,2);


INSERT INTO tb_departamento (nome) VALUES ('Tecnologia da Informação');
INSERT INTO tb_departamento (nome) VALUES ('Vendas Interno');
INSERT INTO tb_departamento (nome) VALUES ('Vendas Externo');
INSERT INTO tb_departamento (nome) VALUES ('Faturamento');
INSERT INTO tb_departamento (nome) VALUES ('Compras');
INSERT INTO tb_departamento (nome) VALUES ('Logística');
INSERT INTO tb_departamento (nome) VALUES ('Contas a Pagar');
INSERT INTO tb_departamento (nome) VALUES ('Contas a Receber');
INSERT INTO tb_departamento (nome) VALUES ('Recursos Humanos');

INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Rafael de Luca','5133736800','redes@melhoramentoshigieners.com.br', 1);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Mylene','5133736801','vendas02@melhoramentoshigieners.com.br', 2)
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Alexandre','5133736805','vendas01@melhoramentoshigieners.com.br', 2);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Angelo', '5133736802', 'vendas07@melhoramentoshigieners.com.br',2);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Fernanda', '5133736813', 'compras@melhoramentoshigieners.com.br',5);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Fernanda', '5133736813', 'controladoria@melhoramentoshigieners.com.br',7);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Carolina', '5133736808', 'faturamento@melhoramentoshigieners.com.br',5);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Carolina', '5133736809', 'cobranca@melhoramentoshigieners.com.br',8);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Marco', '5133736812', 'rh@melhoramentoshigieners.com.br',9);
INSERT INTO tb_colaborador (nome, telefone, email, departamento_id) VALUES ('Dênio', '5133736835', 'logistica@melhoramentoshigieners.com.br',6);





