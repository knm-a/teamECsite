package jp.co.internous.hope.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.hope.model.domain.TblCart;
import jp.co.internous.hope.model.domain.dto.CartDto;

@Mapper
public interface TblCartMapper {
	
	//ユーザーIDに紐づくカート情報を取得
	List<CartDto> findByUserId(@Param("userId") int userId);
	
	@Insert("INSERT INTO tbl_cart(user_id,product_id,product_count)VALUES(#{userId},#{productId},#{productCount})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(TblCart cart);
	
	@Update("UPDATE tbl_cart SET product_count = product_count + #{productCount} WHERE user_id = #{userId} AND product_id =#{productId}")
	int update(TblCart cart);
	
	@Select("SELECT count(user_id) FROM tbl_cart WHERE user_id =#{userId}")
	int findCountByUserId(@Param("userId") int userId);
	
	@Update("UPDATE tbl_cart SET user_id = #{userId} WHERE user_id = #{tmpUserId}")
	int updateUserId(@Param("userId") int userId, @Param("tmpUserId") int tmpUserId);
	
	@Select("SELECT count(id) FROM tbl_cart WHERE user_id = #{userId} AND product_id = #{productId}")
	int findCountByUserIdAndProductId(@Param("userId") int userId, @Param("productId") int productId);
	
	@Delete("DELETE FROM tbl_cart WHERE id = #{id}")
	int deleteById(@Param("id") int id);
	
	@Delete("DELETE FROM tbl_cart WHERE user_id = #{userId}")
	int deleteByUserId(@Param("userId") int userId);
}