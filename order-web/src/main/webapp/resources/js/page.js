/**
 * 分页列表
 */
function docReady() {
	
	var prePage = function(){
		$('#searchForm #currentPage').attr('value',Number($('#currentPage').val()) - 1);
		search();
	};
	
	var nextPage = function(){
		$('#searchForm #currentPage').attr('value',Number($('#currentPage').val())+1);
		search();
	};
	
	var afterQuery = function(params) {
		$('#listcontent a.queryDynamicModal').dynamicModal({modalForm:"#queryModal",onLoad:reloadModal});
		$('#listcontent button.addDynamicModal').dynamicModal({modalForm:"#addModal",onLoad:reloadModal});
		pageBind(prePage, nextPage);
		useStrapTitle('#listcontent');
	};
	
	//模板列表页面查询
	var search = function(){
		$('#searchForm').ajaxFormSubmit({
			loadingButtonIds : ['search'],
			success : function(html){
				$('#listcontent').html(html);
				afterQuery();
			},error : function(){
				alert('系统有点繁忙，请稍后再试！');
			}
		});
	};
}
