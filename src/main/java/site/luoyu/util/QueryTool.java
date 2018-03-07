package site.luoyu.util;

/**
 *选择排序手段
 * 这个类先暂时禁用了
 */
public final class QueryTool {
	/**
	 //jpa查询
	public static Pageable buildPageRequest(int pageNumber,int pageSize,String sortType){
		Sort sort = null;
		if("bookid".equals(sortType)){
			sort = new Sort(Direction.DESC, "bookid");//默认排序
		}else if("price".equals(sortType)){
			sort = new Sort(Direction.DESC, "price");//按价格排序
		}else {
			sort = new Sort(Direction.DESC, "recommendStar");//按星级排序
		}
		return new PageRequest(pageNumber, pageSize, sort);
	}
	 */
}
