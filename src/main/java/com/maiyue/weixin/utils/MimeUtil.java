package com.maiyue.weixin.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class MimeUtil {

	private static Map<String,Object> mime = new HashMap<String,Object>();
	
	
	static {
		mime.put("video/3gpp", "3gpp");
		mime.put("video/mp4", "mp4");
		
		mime.put("audio/3gpp", "3gpp");
		mime.put("audio/ac3", "ac3");
		mime.put("audio/basic", "au");
		mime.put("audio/basic", "au");
		mime.put("audio/mpeg", "mp3");
		mime.put("audio/mp4", "mp4");
		mime.put("audio/ogg", "ogg");
		
		mime.put("image/vnd.dwg", "dwg");
		mime.put("image/vnd.dxf", "dxf");
		mime.put("image/gif", "gif");
		mime.put("image/jp2", "jp2");
		mime.put("image/jpeg", "jpe-jpeg-jpg");
		mime.put("image/vnd.svf", "svf");
		mime.put("image/tiff", "tif");
		mime.put("image/png", "png");
		
		mime.put("text/css", "css");
		mime.put("text/csv", "csv");
		mime.put("text/html", "html");
		mime.put("text/rtf", "rtf");
		mime.put("text/javascript", "js");
		mime.put("text/plain", "txt");
		mime.put("text/xml", "xml");
		
		
		mime.put("weixinlication/msword", "msword");
		mime.put("weixinlication/envoy", "evy");
		
		mime.put("weixinlication/javascript", "js");
		mime.put("weixinlication/json", "json");
		
		mime.put("weixinlication/pdf", "pdf");
		mime.put("weixinlication/ogg", "ogg");
		mime.put("weixinlication/rtf", "rtf");
		
		mime.put("weixinlication/xhtml+xml", "xhtml");
		mime.put("weixinlication/xml", "xml");
		mime.put("weixinlication/xml-dtd", "dtd");
		
		mime.put("weixinlication/vnd.ms-excel", "xls");
		mime.put("weixinlication/vnd.ms-asf", "asf");
		mime.put("weixinlication/vnd.ms-works", "wps");
		mime.put("weixinlication/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
		mime.put("weixinlication/vnd.ms-powerpoint", "ppt");
		mime.put("weixinlication/vnd.ms-project", "mmp");
		
		mime.put("aplication/zip", "zip");
		mime.put("aplication/octet-stream", "stream");
		
		
		/*
		weixinlication/fractals	fif
		weixinlication/futuresplash	spl
		weixinlication/hta	hta
		weixinlication/internet-property-stream	acx
		weixinlication/mac-binhex40	hqx
		weixinlication/oda	oda
		weixinlication/olescript	axs
		weixinlication/pdf	pdf
		weixinlication/pics-rules	prf
		weixinlication/pkcs10	p10
		weixinlication/pkix-crl	crl
		weixinlication/postscript	ai
		weixinlication/postscript	eps
		weixinlication/postscript	ps
		weixinlication/rtf	rtf
		weixinlication/set-payment-initiation	setpay
		weixinlication/set-registration-initiation	setreg
		weixinlication/vnd.ms-excel	xla
		weixinlication/vnd.ms-outlook	msg
		weixinlication/vnd.ms-pkicertstore	sst
		weixinlication/vnd.ms-pkiseccat	cat
		weixinlication/vnd.ms-pkistl	stl
		weixinlication/vnd.ms-powerpoint	pot
		weixinlication/vnd.ms-powerpoint	pps
		weixinlication/vnd.ms-powerpoint	ppt
		weixinlication/vnd.ms-project	mpp
		weixinlication/vnd.ms-works	wcm
		weixinlication/vnd.ms-works	wdb
		weixinlication/vnd.ms-works	wks
		weixinlication/vnd.ms-works	wps
		weixinlication/winhlp	hlp
		weixinlication/x-bcpio	bcpio
		weixinlication/x-cdf	cdf
		weixinlication/x-compress	z
		weixinlication/x-compressed	tgz
		weixinlication/x-cpio	cpio
		weixinlication/x-csh	csh
		weixinlication/x-director	dcr
		weixinlication/x-director	dir
		weixinlication/x-director	dxr
		weixinlication/x-dvi	dvi
		weixinlication/x-gtar	gtar
		weixinlication/x-gzip	gz
		weixinlication/x-hdf	hdf
		weixinlication/x-internet-signup	ins
		weixinlication/x-internet-signup	isp
		weixinlication/x-iphone	iii
		weixinlication/x-javascript	js
		weixinlication/x-latex	latex
		weixinlication/x-msaccess	mdb
		weixinlication/x-mscardfile	crd
		weixinlication/x-msclip	clp
		weixinlication/x-msdownload	dll
		weixinlication/x-msmediaview	m13
		weixinlication/x-msmediaview	m14
		weixinlication/x-msmediaview	mvb
		weixinlication/x-msmetafile	wmf
		weixinlication/x-msmoney	mny
		weixinlication/x-mspublisher	pub
		weixinlication/x-msschedule	scd
		weixinlication/x-msterminal	trm
		weixinlication/x-mswrite	wri
		weixinlication/x-netcdf	cdf
		weixinlication/x-netcdf	nc
		weixinlication/x-perfmon	pma
		weixinlication/x-perfmon	pmc
		weixinlication/x-perfmon	pml
		weixinlication/x-perfmon	pmr
		weixinlication/x-perfmon	pmw
		weixinlication/x-pkcs12	p12
		weixinlication/x-pkcs12	pfx
		weixinlication/x-pkcs7-certificates	p7b
		weixinlication/x-pkcs7-certificates	spc
		weixinlication/x-pkcs7-certreqresp	p7r
		weixinlication/x-pkcs7-mime	p7c
		weixinlication/x-pkcs7-mime	p7m
		weixinlication/x-pkcs7-signature	p7s
		weixinlication/x-sh	sh
		weixinlication/x-shar	shar
		weixinlication/x-shockwave-flash	swf
		weixinlication/x-stuffit	sit
		weixinlication/x-sv4cpio	sv4cpio
		weixinlication/x-sv4crc	sv4crc
		weixinlication/x-tar	tar
		weixinlication/x-tcl	tcl
		weixinlication/x-tex	tex
		weixinlication/x-texinfo	texi
		weixinlication/x-texinfo	texinfo
		weixinlication/x-troff	roff
		weixinlication/x-troff	t
		weixinlication/x-troff	tr
		weixinlication/x-troff-man	man
		weixinlication/x-troff-me	me
		weixinlication/x-troff-ms	ms
		weixinlication/x-ustar	ustar
		weixinlication/x-wais-source	src
		weixinlication/x-x509-ca-cert	cer
		weixinlication/x-x509-ca-cert	crt
		weixinlication/x-x509-ca-cert	der
		weixinlication/ynd.ms-pkipko	pko
		weixinlication/zip
		
		audio/basic	au
		audio/basic	snd
		audio/mid	mid
		audio/mid	rmi
		audio/mpeg	mp3
		audio/x-aiff	aif
		audio/x-aiff	aifc
		audio/x-aiff	aiff
		audio/x-mpegurl	m3u
		audio/x-pn-realaudio	ra
		audio/x-pn-realaudio	ram
		audio/x-wav	wav
		image/bmp	bmp
		image/cis-cod	cod
		image/gif	gif
		image/ief	ief
		image/jpeg	jpe
		image/jpeg	jpeg
		image/jpeg	jpg
		image/pipeg	jfif
		image/svg+xml	svg
		image/tiff	tif
		image/tiff	tiff
		image/x-cmu-raster	ras
		image/x-cmx	cmx
		image/x-icon	ico
		image/x-portable-anymap	pnm
		image/x-portable-bitmap	pbm
		image/x-portable-graymap	pgm
		image/x-portable-pixmap	ppm
		image/x-rgb	rgb
		image/x-xbitmap	xbm
		image/x-xpixmap	xpm
		image/x-xwindowdump	xwd
		message/rfc822	mht
		message/rfc822	mhtml
		message/rfc822	nws
		text/css	css
		text/h323	323
		text/html	htm
		text/html	html
		text/html	stm
		text/iuls	uls
		text/plain	bas
		text/plain	c
		text/plain	h
		text/plain	txt
		text/richtext	rtx
		text/scriptlet	sct
		text/tab-separated-values	tsv
		text/webviewhtml	htt
		text/x-component	htc
		text/x-setext	etx
		text/x-vcard	vcf
		video/mpeg	mp2
		video/mpeg	mpa
		video/mpeg	mpe
		video/mpeg	mpeg
		video/mpeg	mpg
		video/mpeg	mpv2
		video/quicktime	mov
		video/quicktime	qt
		video/x-la-asf	lsf
		video/x-la-asf	lsx
		video/x-ms-asf	asf
		video/x-ms-asf	asr
		video/x-ms-asf	asx
		video/x-msvideo	avi
		video/x-sgi-movie	movie
		x-world/x-vrml	flr
		x-world/x-vrml	vrml
		x-world/x-vrml	wrl
		x-world/x-vrml	wrz
		x-world/x-vrml	xaf
		x-world/x-vrml

		323	text/h323
		acx	weixinlication/internet-property-stream
		ai	weixinlication/postscript
		aif	audio/x-aiff
		aifc	audio/x-aiff
		aiff	audio/x-aiff
		asf	video/x-ms-asf
		asr	video/x-ms-asf
		asx	video/x-ms-asf
		au	audio/basic
		avi	video/x-msvideo
		axs	weixinlication/olescript
		bas	text/plain
		bcpio	weixinlication/x-bcpio
		bin	weixinlication/octet-stream
		bmp	image/bmp
		c	text/plain
		cat	weixinlication/vnd.ms-pkiseccat
		cdf	weixinlication/x-cdf
		cer	weixinlication/x-x509-ca-cert
		class	weixinlication/octet-stream
		clp	weixinlication/x-msclip
		cmx	image/x-cmx
		cod	image/cis-cod
		cpio	weixinlication/x-cpio
		crd	weixinlication/x-mscardfile
		crl	weixinlication/pkix-crl
		crt	weixinlication/x-x509-ca-cert
		csh	weixinlication/x-csh
		css	text/css
		dcr	weixinlication/x-director
		der	weixinlication/x-x509-ca-cert
		dir	weixinlication/x-director
		dll	weixinlication/x-msdownload
		dms	weixinlication/octet-stream
		doc	weixinlication/msword
		dot	weixinlication/msword
		dvi	weixinlication/x-dvi
		dxr	weixinlication/x-director
		eps	weixinlication/postscript
		etx	text/x-setext
		evy	weixinlication/envoy
		exe	weixinlication/octet-stream
		fif	weixinlication/fractals
		flr	x-world/x-vrml
		gif	image/gif
		gtar	weixinlication/x-gtar
		gz	weixinlication/x-gzip
		h	text/plain
		hdf	weixinlication/x-hdf
		hlp	weixinlication/winhlp
		hqx	weixinlication/mac-binhex40
		hta	weixinlication/hta
		htc	text/x-component
		htm	text/html
		html	text/html
		htt	text/webviewhtml
		ico	image/x-icon
		ief	image/ief
		iii	weixinlication/x-iphone
		ins	weixinlication/x-internet-signup
		isp	weixinlication/x-internet-signup
		jfif	image/pipeg
		jpe	image/jpeg
		jpeg	image/jpeg
		jpg	image/jpeg
		js	weixinlication/x-javascript
		latex	weixinlication/x-latex
		lha	weixinlication/octet-stream
		lsf	video/x-la-asf
		lsx	video/x-la-asf
		lzh	weixinlication/octet-stream
		m13	weixinlication/x-msmediaview
		m14	weixinlication/x-msmediaview
		m3u	audio/x-mpegurl
		man	weixinlication/x-troff-man
		mdb	weixinlication/x-msaccess
		me	weixinlication/x-troff-me
		mht	message/rfc822
		mhtml	message/rfc822
		mid	audio/mid
		mny	weixinlication/x-msmoney
		mov	video/quicktime
		movie	video/x-sgi-movie
		mp2	video/mpeg
		mp3	audio/mpeg
		mpa	video/mpeg
		mpe	video/mpeg
		mpeg	video/mpeg
		mpg	video/mpeg
		mpp	weixinlication/vnd.ms-project
		mpv2	video/mpeg
		ms	weixinlication/x-troff-ms
		mvb	weixinlication/x-msmediaview
		nws	message/rfc822
		oda	weixinlication/oda
		p10	weixinlication/pkcs10
		p12	weixinlication/x-pkcs12
		p7b	weixinlication/x-pkcs7-certificates
		p7c	weixinlication/x-pkcs7-mime
		p7m	weixinlication/x-pkcs7-mime
		p7r	weixinlication/x-pkcs7-certreqresp
		p7s	weixinlication/x-pkcs7-signature
		pbm	image/x-portable-bitmap
		pdf	weixinlication/pdf
		pfx	weixinlication/x-pkcs12
		pgm	image/x-portable-graymap
		pko	weixinlication/ynd.ms-pkipko
		pma	weixinlication/x-perfmon
		pmc	weixinlication/x-perfmon
		pml	weixinlication/x-perfmon
		pmr	weixinlication/x-perfmon
		pmw	weixinlication/x-perfmon
		pnm	image/x-portable-anymap
		pot,	weixinlication/vnd.ms-powerpoint
		ppm	image/x-portable-pixmap
		pps	weixinlication/vnd.ms-powerpoint
		ppt	weixinlication/vnd.ms-powerpoint
		prf	weixinlication/pics-rules
		ps	weixinlication/postscript
		pub	weixinlication/x-mspublisher
		qt	video/quicktime
		ra	audio/x-pn-realaudio
		ram	audio/x-pn-realaudio
		ras	image/x-cmu-raster
		rgb	image/x-rgb
		rmi	audio/mid
		roff	weixinlication/x-troff
		rtf	weixinlication/rtf
		rtx	text/richtext
		scd	weixinlication/x-msschedule
		sct	text/scriptlet
		setpay	weixinlication/set-payment-initiation
		setreg	weixinlication/set-registration-initiation
		sh	weixinlication/x-sh
		shar	weixinlication/x-shar
		sit	weixinlication/x-stuffit
		snd	audio/basic
		spc	weixinlication/x-pkcs7-certificates
		spl	weixinlication/futuresplash
		src	weixinlication/x-wais-source
		sst	weixinlication/vnd.ms-pkicertstore
		stl	weixinlication/vnd.ms-pkistl
		stm	text/html
		svg	image/svg+xml
		sv4cpio	weixinlication/x-sv4cpio
		sv4crc	weixinlication/x-sv4crc
		swf	weixinlication/x-shockwave-flash
		t	weixinlication/x-troff
		tar	weixinlication/x-tar
		tcl	weixinlication/x-tcl
		tex	weixinlication/x-tex
		texi	weixinlication/x-texinfo
		texinfo	weixinlication/x-texinfo
		tgz	weixinlication/x-compressed
		tif	image/tiff
		tiff	image/tiff
		tr	weixinlication/x-troff
		trm	weixinlication/x-msterminal
		tsv	text/tab-separated-values
		txt	text/plain
		uls	text/iuls
		ustar	weixinlication/x-ustar
		vcf	text/x-vcard
		vrml	x-world/x-vrml
		wav	audio/x-wav
		wcm	weixinlication/vnd.ms-works
		wdb	weixinlication/vnd.ms-works
		wks	weixinlication/vnd.ms-works
		wmf	weixinlication/x-msmetafile
		wps	weixinlication/vnd.ms-works
		wri	weixinlication/x-mswrite
		wrl	x-world/x-vrml
		wrz	x-world/x-vrml
		xaf	x-world/x-vrml
		xbm	image/x-xbitmap
		xla	weixinlication/vnd.ms-excel
		xlc	weixinlication/vnd.ms-excel
		xlm	weixinlication/vnd.ms-excel
		xls	weixinlication/vnd.ms-excel
		xlt	weixinlication/vnd.ms-excel
		xlw	weixinlication/vnd.ms-excel
		xof	x-world/x-vrml
		xpm	image/x-xpixmap
		xwd	image/x-xwindowdump
		z	weixinlication/x-compress
		zip	weixinlication/zip
		*/
		
	}
	
	
	/***
	 * 获取文件类型文件夹
	 * @param type
	 * @return
	 */
	public static String getMimeFolder(String type){
		if(StringUtils.isBlank(type)){
			return "other";
		}
		if(mime.get(type)==null){
			return "other";
		}else{
			return (String) mime.get(type);
		}
	}
	
	
	
	
}
