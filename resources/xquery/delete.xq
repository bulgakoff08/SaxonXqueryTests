for $item in fn:doc('resources/xml/example.xml')//items/item
where $item/@status = 'complete'
return delete node $item