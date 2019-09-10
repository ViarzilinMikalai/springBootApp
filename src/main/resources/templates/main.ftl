<#include "parts/security.ftl">
<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
<h1>Hello, <#if user??>${name}<#else>guest</#if>!</h1>
<div>It's a Car registration application</div>
</@pt.page>
