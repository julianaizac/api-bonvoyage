package com.facens.apibonvoyage.application.swagger;

public class SwaggerConstantes {

    // HOTEL
    public static final String NOME_CONTROLLER_HOTEL = "Hotéis";
    public static final String DESCRICAO_CONTROLLER_HOTEL = "Operações relacionadas a hotéis";

    public static final String GET_HOTEL = "Buscar";
    public static final String GET_HOTEL_DESCRIPTION = "Busca hotéis cadastrados";

    public static final String GET_HOTEL_BY_ID = "Busca por id";
    public static final String GET_HOTEL_BY_ID_DESCRIPTION = "Busca os hoteis por id";

    public static final String POST_HOTEL = "Salvar";
    public static final String POST_HOTEL_DESCRIPTION = "Salvar um novo hotel";

    public static final String PATCH_HOTEL_BY_ID = "Atualizar";
    public static final String PATCH_HOTEL_BY_ID_DESCRIPTION = "Atualizar um hotel existente";

    public static final String DELETE_HOTEL_BY_ID = "Deletar";
    public static final String DELETE_HOTEL_BY_ID_DESCRIPTION = "Deleta um hotel";

    // QUARTO
    public static final String NOME_CONTROLLER_QUARTO = "Quartos";
    public static final String DESCRICAO_CONTROLLER_QUARTO = "Operações relacionadas a quartos de hotéis";

    public static final String GET_QUARTO_BY_ID = "Busca por id";
    public static final String GET_QUARTO_BY_ID_DESCRIPTION = "Busca quarto por id";

    public static final String POST_QUARTO = "Salvar";
    public static final String POST_QUARTO_DESCRIPTION = "Insere um novo quarto";

    public static final String PATCH_QUARTO_BY_ID = "Atualizar";
    public static final String PATCH_QUARTO_BY_ID_DESCRIPTION = "Atualiza um quarto existente";

    public static final String DELETE_QUARTO_BY_ID = "Deletar";
    public static final String DELETE_QUARTO_BY_ID_DESCRIPTION = "Deleta um quarto";

    // DTOS
    public static final String ID_HOTEL_DESCRICAO = "Id único do hotel";
    public static final String ID_HOTEL_EXEMPLO = "560403a7-bd73-4adc-8628-015d4e323e09";

    public static final String NOME_HOTEL_DESCRICAO = "Nome do hotel";
    public static final String NOME_HOTEL_EXEMPLO = "Hotel Bon Voyage";

    public static final String ENDERECO_HOTEL_DESCRICAO = "Endereço do hotel";
    public static final String ENDERECO_HOTEL_EXEMPLO = "Rua Bon Voyage";

    public static final String ESTADO_HOTEL_DESCRICAO = "Estado do hotel";
    public static final String ESTADO_HOTEL_EXEMPLO = "São Paulo";

    public static final String ID_QUARTO_DESCRICAO = "Id único do quarto";
    public static final String ID_QUARTO_EXEMPLO = "1";

    public static final String QTD_CAMA_SOLTEIRO_QUARTO_DESCRICAO = "Quantidade de cama de solteiro";
    public static final String QTD_CAMA_SOLTEIRO_QUARTO_EXEMPLO = "2";
    public static final String QTD_CAMA_CASAL_QUARTO_DESCRICAO = "Quantidade de cama de casal";
    public static final String QTD_CAMA_CASAL_QUARTO_EXEMPLO = "1";
    public static final String QTD_CAMA_BELICHE_QUARTO_DESCRICAO = "Quantidade de beliche";
    public static final String QTD_CAMA_BELICHE_QUARTO_EXEMPLO = "0";

    public static final String CATEGORIA_QUARTO_DESCRICAO = "Categoria do quarto";
    public static final String CATEGORIA_QUARTO_EXEMPLO = "ECONOMICO";

    public static final String STATUS_QUARTO_DESCRICAO = "Status do quarto";
    public static final String STATUS_QUARTO_EXEMPLO = "DISPONIVEL";

    public static final String ID_HOTEL_QUARTO_DESCRICAO = "Id único do hotel";
    public static final String ID_HOTEL_QUARTO_EXEMPLO = "560403a7-bd73-4adc-8628-015d4e323e09";

    public static final String ESTRELAS_HOTEL_DESCRICAO = "Classificação do hotel em estrelas";
    public static final String ESTRELAS_HOTEL_EXEMPLO = "4";


}
