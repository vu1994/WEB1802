/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.plugins.addExternal('onchange');

CKEDITOR.editorConfig = function(config)
{
	config.extraPlugins = 'onchange';
	config.resize_dir = 'vertical';
	
	config.filebrowserBrowseUrl = '';
	config.filebrowserFlashBrowseUrl = '';
	config.filebrowserFlashUploadUrl = '';
	config.filebrowserImageBrowseLinkUrl = '';
	config.filebrowserImageBrowseUrl = '';
	config.filebrowserImageUploadUrl = '';
	config.filebrowserUploadUrl = '';
	
	config.toolbar = 'Custom';
	
	config.toolbar_Custom = [
		["Image","-","Bold","Italic","Underline","Strike","-","NumberedList","BulletedList","-","Outdent","Indent","Blockquote","-","Link","Unlink","-","Table","SpecialChar","-","Cut","Copy","Paste","-","Undo","Redo","-"],
		['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		['Styles','Format','Font','FontSize'],
		['TextColor','BGColor'],
		['Source']
	];
	
	config.toolbar_Custom_Short = [
		["Image","-","Bold","Italic","Underline","Strike","-","NumberedList","BulletedList","-","Outdent","Indent","Blockquote","-","Link","Unlink","-","Table","SpecialChar","-","Cut","Copy","Paste","-","Undo","Redo","-"]
	];
	
};