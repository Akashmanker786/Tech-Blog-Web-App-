
function doLike(pId , uId){
    
    const obj = {
        pId : pId,
        uId : uId,
        operation : 'like'
    }
    
    $.ajax({
        
        url: "LikeServlet",
        data: obj,
        
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            
            
            if(data.trim()=='true'){
                let c = $(".like-counter").html();
                c++;
                $('.like-counter').html(c);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(data);
        }
    })
}