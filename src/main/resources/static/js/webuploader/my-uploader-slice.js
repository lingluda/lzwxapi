$(function() {
	 $list = $('#fileList');
     var flie_count = 0;
     var sizeTotal  = 0;
     var uploader = WebUploader.create({
         //设置选完文件后是否自动上传
         auto: false,
         //swf文件路径
         swf: '/swf/Uploader.swf',
         // 文件接收服务端。
         server: 'chunkUpload.do',
         // 选择文件的按钮。可选。
         // 内部根据当前运行是创建，可能是input元素，也可能是flash.
         pick: '#picker',
         chunked: true, //开启分块上传
         chunkSize: 3 * 1024 * 1024,//8MB
         chunkRetry: 3,//网络问题上传失败后重试次数
         threads: 1, //上传并发数
         //fileNumLimit :1,
         fileSizeLimit: 2000 * 1024 * 1024,//最大2GB
         fileSingleSizeLimit: 2000 * 1024 * 1024,
         resize: false,//不压缩
         prepareNextFile:true,
     });
     
     // 当有文件被添加进队列的时候
     uploader.on('fileQueued', function (file) {
         $list.weixinend('<div id="' + file.id + '" class="item">' +
		                 '<h5 class="info"><span style="width:80%;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 20em;">' + file.name + '</span>' + 
		                     '<span style="float: right;">' +
			                     '<span class="state" style="font-size:12px;color:#908e8e;">文件校验中...</span>&nbsp;&nbsp;&nbsp;'+ 
			                     '<a class="up-retry-btn" fileId="' + file.id + '" title="重新上传" style="cursor: pointer;margin-right:10px;display:none;">' + //btn btn-danger 
			                        '<span class="glyphicon glyphicon-refresh"></span>'+
			                 	 '</a>' +
			                 	 '<a class="up-pause-btn-'+file.id+'" st="pause" title="暂停" style="cursor: pointer;margin-right:10px;display:none;">' + //btn btn-danger 
			                        '<span class="glyphicon glyphicon-pause"></span>'+
			                 	 '</a>' +
			                 	 '<a class="up-delete-btn" fileId="' + file.id + '" title="删除" style="cursor: pointer;">' + //btn btn-danger 
			                        '<span class="glyphicon glyphicon-trash"></span>'+
			                 	 '</a>' +
		                 	 '</span>' +
		                 '</h5>' +
		                 '<div class="md5-progress" style="background:#5893ef6b;margin-top:15px;margin-bottom:-10px;height:1px;width:0px;"></div>' + 
			             '<div class="progress" style="height: 10px;margin-bottom: 10px;margin-top: 15px;background:#f1f1f175;">'+
			                 '<div class="progress-bar progress-bar-info" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' + 
			             '</div>' +
	                 '</div>');
         flie_count++;
         $('#up-title').fadeOut(1);
         //删除要上传的文件
         //每次添加文件都给up-delete-btn绑定删除方法
         $(".up-delete-btn").click(function () {
             //$(this).attr("fileId");//拿到文件id status="suspend"
             uploader.removeFile(uploader.getFile($(this).attr("fileId"), true));
             $(this).parent().parent().parent().fadeOut();//视觉上消失了
             $(this).parent().parent().parent().remove();//DOM上删除了
             sizeTotal = (sizeTotal - file.size);
             flie_count= (flie_count-1);
             if(sizeTotal <= 0){
            	 sizeTotal = 0;
            	 flie_count = 0;
            	 $('#up-title').fadeIn();
            	 $('.up-dateil').html('');
             }else{
            	 $('.up-dateil').html('<h5>共'+flie_count+'个文件,大小为：'+WebUploader.formatSize(sizeTotal)+'</h5>');
             }
         });
         $('.up-dateil').html('<h5>共 '+flie_count+' 个文件');
         //md5计算
         //每个文件都附带一个md5标识
         uploader.md5File(file).progress(function(percentage) {
        	     if(percentage != 1){
        	    	 $('#' + file.id).find('.md5-progress').css('width',percentage * 100 + '%');
        	     }else{
        	    	 $('#' + file.id).find('.md5-progress').css('display','none');
        	     }
             }).then(function (fileMd5) { // 完成
                 file.wholeMd5 = fileMd5;//获取到了md5
                 $('#' + file.id).find('span.state').text('校验完成 (' + WebUploader.formatSize(file.size) + ")");
                 sizeTotal += file.size;
                 $('.up-dateil').html('<h5>共 '+flie_count+' 个文件,总大小为：'+WebUploader.formatSize(sizeTotal)+'</h5>');
         });
         //暂停
         $(".up-pause-btn-" + file.id).click(function () {
        	 var st = $('.up-pause-btn-' + file.id).attr('st');
        	 if(st == 'pause'){
        		 uploader.stop(true);
        		 $('.up-pause-btn-' + file.id).attr('st','continue');
        		 $('.up-pause-btn-' + file.id).attr('title','继续');
        		 $('.up-pause-btn-' + file.id).find('.glyphicon').attr("class", "glyphicon glyphicon-play");
        		 $opSign = "pause";
        	 }else{
        		 uploader.upload();
        		 $('.up-pause-btn-' + file.id).attr('st','pause');
        		 $('.up-pause-btn-' + file.id).attr('title','暂停');
        		 $('.up-pause-btn-' + file.id).find('.glyphicon').attr("class", "glyphicon glyphicon-pause");
        	 }
     	 });
     });
     
     //发送前填充数据
     uploader.on('uploadBeforeSend', function(block,data) {
         // block为分块数据。
         // file为分块对应的file对象。
         var fileMd5 = block.file.wholeMd5;
         // 修改data可以控制发送哪些携带数据。
         // 将存在file对象中的md5数据携带发送过去。
         data.md5value = fileMd5;//md5
     });
   
     // 文件上传过程中创建进度条实时显示。
     uploader.on('uploadProgress', function (file, percentage) {
         var $li = $('#' + file.id),
             $percent = $li.find('.progress-bar-info').css('width', percentage * 100 + '%');
             // 避免重复创建
             $li.find('span.state').text('上传中('+(percentage*100).toFixed(1)+'%)');
             $li.find(".up-delete-btn").fadeOut('fast');//上传完后删除"删除"按钮
             $li.find(".up-pause-btn-" + file.id).fadeIn('fast');//暂停按钮
             //禁止使用开始按钮 disabled
             $('#UploadBtn').css('background','#8a8a8a');
             $('#UploadBtn').attr('disabled','disabled');
     });

     //上传成功
     uploader.on('uploadSuccess',function(file,res) {
         $('#' + file.id).find('span.state').text('上传成功！');
         $('#' + file.id).find(".progress").find(".progress-bar").attr("class", "progress-bar progress-bar-success");
         $('#' + file.id).find(".up-delete-btn").css('display','none');//删除按钮
         $('#' + file.id).find(".up-retry-btn").css('display','none');//重新上传按钮
         $('#' + file.id).find(".up-pause-btn-" + file.id).css('display','none');//暂停按钮
         
         console.log("res:" + res.RetData);
         
     });
     
     //出错
     uploader.on('uploadError', function (file) {
         $('#' + file.id).find('span.state').text('上传出错!');
         $('#' + file.id).find(".up-delete-btn").fadeIn('fast');
         //为了防止重复添加重试按钮，做一个判断
         $('#' + file.id).find(".up-retry-btn").fadeIn('fast');
         //上传出错后进度条变红
         $('#' + file.id).find(".progress").find(".progress-bar").attr("class", "progress-bar progress-bar-danger");
         //添加重试按钮
         //重新上传
         $(".up-retry-btn").click(function () {
             uploader.retry(uploader.getFile($(this).attr("fileId")));
         });
     });
     
     //上传完成后回调
     uploader.on('uploadComplete', function (file) {//
         //启用使用开始按钮 disabled
         $('#UploadBtn').css('background','#00b7ee');
         $('#UploadBtn').removeAttr('disabled');
         //启用使用选择按钮 disabled
         $('#picker').css('background','#00b7ee');
         $('#picker').removeAttr('disabled');
     });
     
     //上传完成
     uploader.on('uploadFinished', function () {
         //上传完后的回调方法
         //alert("所有文件上传完毕");
         //提交表单
     });
     
     //点击上传
     $("#UploadBtn").click(function () {
         uploader.upload();//上传
         //禁止使用选择按钮 disabled
         $('#picker').css('background','#8a8a8a');
         $('#picker').attr('disabled','disabled');
     });
     
     uploader.on('uploadAccept', function (file, response) {
         if (response._raw === '{"error":true}') {
             return false;
         }
     });
});