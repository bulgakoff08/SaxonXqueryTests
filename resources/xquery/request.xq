for $item in fn:doc('resources/xml/example.xml')//items/item
where $item/@status = 'complete'
return <new_item id='{$item/@id}'>{$item/text}</new_item>