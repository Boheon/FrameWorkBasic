package org.galapagos.mcmorning.exception;

public class UserIdCountOverExeption extends Exception{

    public UserIdCountOverExeption(){
        super("사용자 ID 입력횟수 초과");
    }
}
