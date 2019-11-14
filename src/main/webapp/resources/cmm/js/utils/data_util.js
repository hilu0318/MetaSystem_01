/**
 * 
 */
class DataUtil{
	constructor(){
		this.setDataToGrid;
	}
}

DataUtil.setDataToGrid = function(tableId, dataList){
	var nConLst = new Array();
	var $trTag;
	var $tdTag;
	
	var $tbody = $('#'+ tableId +' > tbody:eq(0)');
	var $nThLst = $('#'+ tableId +' > thead:eq(0) th');
	
	for(var i = 0; i < $nThLst.length; i++){
		nConLst.push( $nThLst.eq(i).attr("id") );
	}
	for(var i = 0; i < dataList.length; i++){
		$trTag = $('<tr id="' + i + '"></tr>');
		for(var j = 0; j < nConLst.length; j++){
			var tempVal = dataList[i][nConLst[j]] === undefined ? "" : dataList[i][nConLst[j]];
			$tdTag = $('<td id="'+ nConLst[j] +'">'+ tempVal +'</td>');
			$trTag.append($tdTag);
		}
		$tbody.append($trTag);
	}
}