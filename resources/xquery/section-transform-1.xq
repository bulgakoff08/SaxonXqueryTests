declare function local:transform ($section as node()) as node() {
    if ($section/name() eq "v_section") then
        let $result := <section width="{$section/@width}" height="{$section/@height}" direction="VERTICAL">{
            for $subsection in $section/*
            return local:transform($subsection)
        }</section>
        return $result
    else
        let $result := $section
        return $result
};

for $section in fn:doc("resources/xml/sections.xml")//page/*
return local:transform($section)