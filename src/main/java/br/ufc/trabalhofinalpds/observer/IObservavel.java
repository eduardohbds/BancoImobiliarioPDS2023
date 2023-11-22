package br.ufc.trabalhofinalpds.observer;

public interface IObservavel {
    public void adicionaObservador(IObservador observador);
	public void removeObservador(IObservador observador);
	public void notifique(String pecaAtual);
}
