/*
 *Author: Yosra Harbaoui
 *Date: October 2017
 *Description: UsersManager Interface
*/

package ch.heigvd.amt.yosra.services;

import javax.ejb.Local;

@Local
public interface UsersManagerLocal
{
    public boolean validateUser(String userName, String password);
    public int getUserId(String userName);
}