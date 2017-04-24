package br.com.syslove.Factory;

import br.com.syslove.Interface.DaoFactorySysLove;

public class DaoFactory {
    public DaoFactorySysLove createFactory(){
        return new DaoFactoryDB();
    }
}
