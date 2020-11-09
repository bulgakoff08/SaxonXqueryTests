for $item in fn:doc('resources/xml/example.xml')//items/item
where $item/@status = 'complete'
return rename node $item as "item_renamed"