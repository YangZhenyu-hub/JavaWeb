function deleteFruit(fid) {
    if (confirm("是否确认删除")){
        window.location.href='del.do?fid='+fid;
    }
}

function page(pageNum) {
    window.location.href='index?pageNum='+pageNum;
}