/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	config.removeDialogTabs = 'image:advance;link:advanced';
	config.filebrowserUploadUrl = 'back/article/uploadfile'; //上传文件保存的路径
	config.filebrowserImageUploadUrl = 'back/article/uploadfile'; //上传图片的保存路径
};
