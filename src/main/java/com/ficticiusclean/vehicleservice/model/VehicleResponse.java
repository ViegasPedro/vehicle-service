/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficticiusclean.vehicleservice.model;

/**
 *
 * @author pedro
 */
public class VehicleResponse {

    private String nome;
    private String marca;
    private String modelo;
    private int ano;
    private double quantidadeCombustivelGasto;
    private double valorCombustivelGasto;

    public VehicleResponse() {
    }

    public VehicleResponse(String nome, String marca, String modelo, int ano, double quantidadeCombustivelGasto, double valorCombustivelGasto) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quantidadeCombustivelGasto = quantidadeCombustivelGasto;
        this.valorCombustivelGasto = valorCombustivelGasto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuantidadeCombustivelGasto() {
        return quantidadeCombustivelGasto;
    }

    public void setQuantidadeCombustivelGasto(double quantidadeCombustivelGasto) {
        this.quantidadeCombustivelGasto = quantidadeCombustivelGasto;
    }

    public double getValorCombustivelGasto() {
        return valorCombustivelGasto;
    }

    public void setValorCombustivelGasto(double valorCombustivelGasto) {
        this.valorCombustivelGasto = valorCombustivelGasto;
    }
    
}
