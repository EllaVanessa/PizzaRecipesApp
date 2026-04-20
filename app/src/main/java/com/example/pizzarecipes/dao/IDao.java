package com.example.pizzarecipes.dao;

import java.util.List;

public interface IDao<T> {

    // Ajouter un élément
    T create(T t);

    // Mettre à jour un élément
    T update(T t);

    // Supprimer par ID
    boolean delete(long id);

    // Trouver par ID
    T findById(long id);

    // Récupérer tous les éléments
    List<T> findAll();
}