package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Program: cloud-study
 * @Description: AuthUserRepository 持久层
 * @Author: Sun
 * @Create: 2019-04-19 12:15
 * @Version: 1.0
 */
@Component
public class AuthUserRepository {

	private static List<AuthUser> authUsers = new ArrayList<AuthUser>();

	static {
		AuthUser o1 = new AuthUser();
		o1.setAccount("account1");
		o1.setPwd("password1");
		o1.setName("name1");
		o1.setId(1L);
		authUsers.add(o1);

		AuthUser o2 = new AuthUser();
		o2.setAccount("account2");
		o2.setPwd("password2");
		o2.setName("name2");
		o2.setId(2L);
		authUsers.add(o2);

		AuthUser o3 = new AuthUser();
		o3.setAccount("account3");
		o3.setPwd("password3");
		o3.setName("name3");
		o3.setId(3L);
		authUsers.add(o3);

		AuthUser o4 = new AuthUser();
		o4.setAccount("account4");
		o4.setPwd("password4");
		o4.setName("name4");
		o4.setId(4L);
		authUsers.add(o4);

	}

	/**
	 * 根据用户账号查询 condition：缓存对象的条件，非必需，也需使用SpEL表达式，只有满足表达式条件的内容才会被缓存，在调用函数之前执行
	 * 比如：@Cacheable(key = "#p0", condition = "#p0.length() <
	 * 3")，表示只有当第一个参数的长度小于3的时候才会被缓存。
	 * 
	 * @param account
	 * @return
	 */
	@Cacheable(value = "authuser", key = "#root.methodName+'['+#account+']'", condition = "#account.length() > 5")
	public AuthUser findByAccount(String account) {

		for (AuthUser auth : authUsers) {
			if (auth.getAccount().equals(account)) {
				return auth;
			}
		}
		return null;
	};

	/**
	 * 查询id大于多少的用户 unless：另外一个缓存条件参数，非必需，需使用SpEL表达式。
	 * 它不同于condition参数的地方在于它的判断时机，该条件是在函数被调用之后才做判断的，所以它可以通过对result进行判断。
	 * 
	 * @param id
	 * @return
	 */
//	@Cacheable(value = "authuser", key = "#id", unless = "#result == null")
//	public List<AuthUser> findAllByIdGreaterThan(Long id, Pageable pageable) {
//		return null;
//	};

	/**
	 * 新增或修改用户
	 * 
	 * @param s
	 * @param <S>
	 * @return
	 */
	@CachePut(value = "authuser", keyGenerator = "objectId")
	public AuthUser save(AuthUser authUser) {

		authUsers.add(authUser);

		return authUser;
	};

//	/**
//	 * 根据id查询用户
//	 * 
//	 * @param aLong
//	 * @return
//	 */
//	@Cacheable(value = "authuser", keyGenerator = "simpleKey")
//	public List<AuthUser> findById(Long aLong) {
//		
//		
//		return null;
//	};

	/**
	 * 根据id删除用户
	 * 
	 * @param aLong
	 */
	@CacheEvict(value = "authuser", keyGenerator = "simpleKey")
	public void deleteById(Long aLong) {

		Iterator<AuthUser> iterator = authUsers.iterator();

		while (iterator.hasNext()) {
			AuthUser auth = iterator.next();

			if (auth.getId().equals(aLong)) {
				iterator.remove();

				return;
			}

		}

	};
}
