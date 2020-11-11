declare function local:transformVerticalSection ($section as node())
as node() {
    for $subsection in $section/v_section
    local:transformVerticalSection($subsection)

    let $result := <section width="{$section/@width}" height="{$section/@height}" direction="VERTICAL">{$section/*}</section>
    return $result
};

for $section in fn:doc("resources/xml/sections.xml")//page/v_section
return local:transformVerticalSection($section)